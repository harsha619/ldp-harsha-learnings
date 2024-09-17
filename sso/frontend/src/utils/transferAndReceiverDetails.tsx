import { RecipientType } from 'components/organisms/recipientForm'

export const generateTransferDetailData = (updatedConvertedAmount: number) => {
  return [
    {
      name: 'Fee',
      value: '00.00 GBP',
    },
    {
      name: "Amount we'll convert",
      value: updatedConvertedAmount.toString() + ' GBP',
    },
    {
      name: 'Guaranteed rate',
      value: '1 GBP = 1.14 EUR',
    },
  ]
}

export const generateRecipientDetailsData = (
  recipientDetails: RecipientType
) => {
  return [
    { name: 'Name', value: recipientDetails.firstName },
    { name: 'Email', value: recipientDetails.email },
    { name: 'Account number', value: recipientDetails.accountNo },
    { name: 'Account type', value: 'Checking' },
  ]
}
