import {
  generateTransferDetailData,
  generateRecipientDetailsData,
} from './transferAndReceiverDetails'

describe('generateTransferDetailData', () => {
  it('generates transfer detail data correctly', () => {
    const updatedConvertedAmount = 100

    const result = generateTransferDetailData(updatedConvertedAmount)

    expect(result).toEqual([
      {
        name: 'Fee',
        value: '00.00 GBP',
      },
      {
        name: "Amount we'll convert",
        value: '100 GBP',
      },
      {
        name: 'Guaranteed rate',
        value: '1 GBP = 1.14 EUR',
      },
    ])
  })
})

describe('generateRecipientDetailsData', () => {
  it('generates recipient details data correctly', () => {
    const recipientDetails = {
      firstName: 'John',
      email: 'john@example.com',
      accountNo: '123456789',
      lastName: 'Ben',
      IFSCCode: 'ABFJ12929G',
    }

    const result = generateRecipientDetailsData(recipientDetails)

    expect(result).toEqual([
      { name: 'Name', value: 'John' },
      { name: 'Email', value: 'john@example.com' },
      { name: 'Account number', value: '123456789' },
      { name: 'Account type', value: 'Checking' },
    ])
  })
})
