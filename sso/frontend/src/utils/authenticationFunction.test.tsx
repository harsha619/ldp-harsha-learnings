import { formatMobileNumber } from './authenticationFunction'

describe('formatMobileNumber', () => {
  test('returns an empty string when the input is empty', () => {
    expect(formatMobileNumber('')).toBe('')
  })

  test('formats string with exactly 7 digits', () => {
    expect(formatMobileNumber('1234567')).toBe('123 4567 ')
  })

  test('formats string with more than 3 digits and fewer than 7 digits', () => {
    expect(formatMobileNumber('1234')).toBe('123 4')
    expect(formatMobileNumber('123456')).toBe('123 456')
  })

  test('formats string with exactly 11 digits', () => {
    expect(formatMobileNumber('12345678901')).toBe('123 4567 8901')
  })
})
