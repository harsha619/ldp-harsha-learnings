export const formatMobileNumber = (value: string) => {
  value = value.replace(/\D/g, '')

  let formattedNumber = ''
  if (value.length > 3) {
    formattedNumber += value.substring(0, 3) + ' '
    if (value.length > 6) {
      formattedNumber += value.substring(3, 7) + ' ' + value.substring(7, 11)
    } else {
      formattedNumber += value.substring(3)
    }
  } else {
    formattedNumber = value
  }

  return formattedNumber
}
