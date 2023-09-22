import {
  evaluatePasswordStrength,
  validateEmailFormat,
  validateField,
} from './credentialUtils'

describe('validateEmailFormat', () => {
  test('returns true for valid email format', () => {
    const validEmails = ['test@example.com', 'infotest@test.com']

    validEmails.forEach((email) => {
      expect(validateEmailFormat(email)).toBe(true)
    })
  })

  test('returns false for invalid email format', () => {
    const invalidEmails = ['test', 'test@', 'test@example']

    invalidEmails.forEach((email) => {
      expect(validateEmailFormat(email)).toBe(false)
    })
  })
})

describe('evaluatePasswordStrength', () => {
  test('returns empty string for a strong password', () => {
    const strongPasswords = ['Abcdefg1!', 'P@ssw0rd!', 'S3cur3P@ss!']

    strongPasswords.forEach((password) => {
      expect(evaluatePasswordStrength(password)).toBe('')
    })
  })

  test('returns error message for a password length if it is less than 8', () => {
    const passwords = ['passwor', 'test']

    passwords.forEach((password) => {
      expect(evaluatePasswordStrength(password)).toContain(
        'Password should have at least 8 characters.'
      )
    })
  })

  test('returns error message for a password missing special characters', () => {
    const passwords = ['Password1', 'Abcdefg1', 'password1', 'Abcdefg1']

    passwords.forEach((password) => {
      expect(evaluatePasswordStrength(password)).toContain(
        'Password should contain at least one special character (!@#$%^&*(),.?":{}|<>).'
      )
    })
  })

  test('returns error message for a password missing numbers', () => {
    const passwords = ['Password!', 'Abcdefg!', 'password!', 'Abcdefg!']

    passwords.forEach((password) => {
      expect(evaluatePasswordStrength(password)).toContain(
        'Password should contain at least one number (0-9).'
      )
    })
  })

  test('returns error message for a password missing lowercase letters', () => {
    const passwords = ['PASSWORD1!', 'ABCDEFG1!', '12345678!', '1!@#$%^&*()']

    passwords.forEach((password) => {
      expect(evaluatePasswordStrength(password)).toContain(
        'Password should contain at least one lowercase letter (a-z).'
      )
    })
  })

  test('returns error message for a password missing uppercase letters', () => {
    const passwords = ['password1!', 'abcdefg1!', 'a12345678!', 'a!1#$%^&*()']

    passwords.forEach((password) => {
      expect(evaluatePasswordStrength(password)).toContain(
        'Password should contain at least one uppercase letter (A-Z).'
      )
    })
  })
})

describe('Validate Feild', () => {
  test('returns true when the input matches the regex expression', () => {
    expect(
      validateField(
        /^[a-zA-Z0-9.]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,}$/,
        'abc@gmail.xyz'
      )
    ).toBe(true)
  })

  test('returns false when the input matches the regex expression', () => {
    expect(
      validateField(/^[a-zA-Z0-9.]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,}$/, 'abc.com')
    ).toBe(false)
  })
})
