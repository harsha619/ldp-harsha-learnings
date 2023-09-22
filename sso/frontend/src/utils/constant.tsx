import { OptionType } from '../components/molecules/autoComplete'
import { MenuType } from '../components/organisms/sideBar'
import Chip from '../components/atoms/Chip'
import googleLogo from '../../public/assets/images/googleLogo.svg'
import facebookLogo from '../../public/assets/images/facebook.svg'
import appleLogo from '../../public/assets/images/apple.svg'
import IND from '../../public/assets/images/IndiaLogo.svg'
import UK from '../../public/assets/images/uk.svg'
import AUSTRIA from '../../public/assets/images/austria.svg'
import ANDORA from '../../public/assets/images/andora.svg'
import cardIcon from '../../public/assets/images/credit-card.svg'
import globeIcon from '../../public/assets/images/globe.svg'
import bankIcon from '../../public/assets/images/bank.svg'
import Home from '../../public/assets/images/home.svg'
import Card from '../../public/assets/images/cvvCard.svg'
import Recipient from '../../public/assets/images/recipient.svg'
import Team from '../../public/assets/images/team.svg'
import User from '../../public/assets/images/person.svg'
import Gift from '../../public/assets/images/gift.svg'
import Plus from '../../public/assets/images/lightPlus.svg'
import sendIcon from '../../public/assets/images/send.svg'
import setupIcon from '../../public/assets/images/setup.svg'
import userIcon from '../../public/assets/images/userIcon.svg'
import settingIcon from '../../public/assets/images/setting.svg'
import helpIcon from '../../public/assets/images/questionMark.svg'
import logoutIcon from '../../public/assets/images/logout.svg'
import theme from '../theme'
import dayjs, { Dayjs } from 'dayjs'
import { SvgIcon } from '@mui/material'
import { SelectOptionType } from '../components/organisms/selectOption'
import configureStore from 'redux-mock-store'
import { VerificationDataType } from 'components/organisms/VerificationForm'
import { RecipientType } from 'components/organisms/recipientForm'
import Sbi from '../../public/assets/images/sbi.svg'
import Hdfc from '../../public/assets/images/hdfc.svg'
import Hsbc from '../../public/assets/images/hsbc.svg'
import Axis from '../../public/assets/images/axis.svg'
import Lloyd from '../../public/assets/images/lloydsBankLogo.svg'
import OtherBankLogo from '../../public/assets/images/otherBankLogo.svg'

export const AUTH0_REDIRECT_URL =
  'https://bc101-fe.fe-assignment.tk/authenticate-user'
export const ALPHABETIC_SPACE_REGEX = /^[A-Za-z\s]+$/
export const NUMERIC_REGEX = /\D/g
export const EMAIL_REGEX = /^[a-zA-Z0-9.]+@[a-zA-Z0-9]+.[a-zA-Z]{2,}$/
export const NAME_REGEX = /^[A-Za-z\s]+$/
export const ACCOUNTNO_REGEX = /^.{14}$/
export const IFSC_REGEX = /^[A-Za-z0-9]+$/
export const DIRECTOR_ROLE = 'Director'
export const DIRECTOR_FORM_HEADING = 'Confirm your business directors'
export const DIRECTOR_FORM_DESC =
  'Please confirm these details from companies house. If anyone’s missing, add them below.'

export const OWNER_ROLE = 'Shareholder'
export const OWNER_FORM_HEADING = 'Confirm your business owners'
export const OWNER_FORM_DESC =
  'Please confirm these details from companies house. If anyone else controls more than 25% of your business, add them below.'
export const OWNER_BTN_TEXt = 'owner'
export const VERIFY_DETAILS_COMPONENTS = [
  'purpose-form',
  'director-form',
  'owner-form',
]

export interface CurrencyType {
  icon: string
  code: string
  label: string
  active: boolean
}

export const currencies: CurrencyType[] = [
  { icon: ANDORA, code: 'EUR', label: 'Andora', active: true },
  { icon: UK, code: 'GBP', label: 'United Kingdom', active: true },
  { icon: AUSTRIA, code: 'AUD', label: 'Austria', active: false },
  { icon: IND, code: 'INR', label: 'India', active: false },
]

export const horizontalStepperValues = [
  'Amount',

  'You',
  'Recipient',
  'Verification',
  'Review',
  'Pay',
]

export const businessDetailsStepperValues = [
  'Your business',
  'Business activity',
  'Your details',
]

export const verticalStepperValues = [
  {
    labelLeft: 'Today at 6:43 pm',
    labelRight: 'You set up your transfer',
  },
  {
    labelLeft: 'Today at 6:44 pm',
    labelRight: 'We received your GBP',
  },
  {
    labelLeft: 'Today at 6:50 pm',
    labelRight: 'Your money’s being processed',
  },
  {
    labelLeft: 'Tomorrow at 12:00 am',
    labelRight: 'We pay out your EUR',
  },
  {
    labelLeft: 'Tomorrow at 6:00 am',
    labelRight: 'George max recieves your EUR',
  },
]

export const Accordion_prop_values = {
  senderName: 'Mario Gabriel',
  status: 'Cancelled',
  sendMoney: '100 GBR',
  receiveMoney: '114.65 EUR',
}

export const DAYS_OF_WEEK: {
  [key: string]: string
} = {
  Su: 'SUN',
  Mo: 'MON',
  Tu: 'TUE',
  We: 'WED',
  Th: 'THU',
  Fr: 'FRI',
  Sa: 'SAT',
}
export const country_options: OptionType[] = [
  { code: ANDORA, label: 'Andorra', disabled: false },
  { code: UK, label: 'United Kingdom', disabled: true },
  { code: AUSTRIA, label: 'Austria', disabled: false },
  { code: IND, label: 'India', disabled: false },
]

export const company_options: OptionType[] = [
  { label: 'Zemoso technologies pvt ltd', disabled: false },
  { label: 'Zentech solutions pvt ltd', disabled: true },
  { label: 'ZedX Infotech pvt ltd', disabled: false },
  { label: 'Zeswe Solutions pvt ltd', disabled: false },
  {
    label: `Can't find your business? `,
    isCustomOption: true,
    disabled: false,
  },
]

export type CreateThirdPartySignUpArrayProps = {
  onGoogleClick: () => void
}

export const createThirdPartySignUpArray = ({
  onGoogleClick,
}: CreateThirdPartySignUpArrayProps) => [
  {
    partyIcon: googleLogo,
    onClick: onGoogleClick,
    active: true,
    testId: 'google-logo',
    isAllowed: true,
  },
  {
    partyIcon: facebookLogo,
    onClick: () => {
      console.log('Facebook Logo')
    },
    active: false,
    testId: 'facebook-logo',
    isAllowed: false,
  },
  {
    partyIcon: appleLogo,
    onClick: () => {
      console.log('Apple Logo')
    },
    active: false,
    testId: 'apple-logo',
    isAllowed: false,
  },
]

export const category_options: OptionType[] = [
  { label: 'Design, marketing or communication', disabled: false },
  { label: 'Health, sports or personal care', disabled: false },
  { label: 'Real estate or construction', disabled: true },
  { label: 'Education or learning', disabled: false },
  { label: 'Others', disabled: false },
]
export type ChangeHandlerType = (
  event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
) => void

export const changeToPinCodeFormat = (code: string) => {
  if (code.length === 5) return code.slice(0, 4) + ' ' + code.slice(4, 5)
  return code
}

export type DetailFormObjectProp = {
  first_name: string
  last_name: string
  dob: string
  country_of_residency: string
  home_address: string
  city: string
  pincode: string
}

export const changeToCustomDate = (date: Dayjs | unknown) => {
  const tempDate: Dayjs = dayjs(date as string | Date)
  return tempDate.format('MM-DD-YYYY')
}
export const checkDisable = (object: DetailFormObjectProp) => {
  const hasEmptyValue = Object.values(object).some(
    (value) => value.length === 0
  )
  return hasEmptyValue
}

export const transferDetailData = [
  {
    name: 'Fee',
    value: '00.00 GBP',
  },
  {
    name: "Amount we'll convert",
    value: '77.74 GBP',
  },
  {
    name: 'Guranteed rate',
    value: '1 GBP = 1.14 EUR',
  },
]
export const recipientDetailsData = [
  { name: 'Name', value: 'Mario Gabriel' },
  { name: 'Email', value: 'mario.gabriel@gmail.com' },
  { name: 'Account number', value: '21363738391910' },
  { name: 'Account type', value: 'Checking' },
]
export const scheduleDetailsData = [
  { name: 'Sending', value: 'Now' },
  { name: 'Should arrive', value: 'by April 28th' },
  { name: 'Repeats', value: 'Never' },
]
export const BUSINESS_DETAILS = {
  businessName: 'Zentech Solutions Pvt Ltd',
  businessNumber: '2020ZEN5367GJ',
  businessAddress:
    '#2097, Triveni Main Rd, Gokula 1st Stage, Nanjappa Reddy Colony, Yeswanthpur, Bengaluru, Karnataka 560054',
}

export const account_type: OptionType[] = [
  { label: 'Checking', disabled: true },
  { label: 'Savings', disabled: false },
]

export const menu_options: MenuType[] = [
  { text: 'Home', imageUrl: Home },
  { text: 'Cards', imageUrl: Card },
  { text: 'Ricipients', imageUrl: Recipient },
  {
    text: 'Team',
    imageUrl: Team,
    chip: (
      <Chip
        label="New"
        variant="outlined"
        sx={{
          color: theme.palette.primaryColor[500],
          backgroundColor: theme.palette.structuralColor.buttonhover,
          width: '63px',
          height: '26px',
        }}
      />
    ),
  },
  { text: 'Account', imageUrl: User },
  { text: 'Invite & earn 150 GBP', imageUrl: Gift },
]

export const balance_options: MenuType[] = [
  { text: '10,000.00 INR', imageUrl: IND },
  { text: '1200 GBP', imageUrl: AUSTRIA },
  { text: '192.00 USD', imageUrl: UK },
  { text: 'Open a balance', imageUrl: Plus },
]

export const PURPOSE_OF_POCKET_PAY_options: OptionType[] = [
  { label: 'Paying rent, utilities or property charges', disabled: false },
  { label: 'Paying suppliers/contractors/employees', disabled: false },
  { label: 'Paying for goods or services abroad', disabled: true },
  { label: 'Paying tax on profit or property', disabled: false },
]
export interface TradingAddress {
  id: number
  serialNo: number
  address: string
}

export const tradingAddresses: TradingAddress[] = [
  {
    id: 1,
    serialNo: 1,
    address:
      '#2097, Triveni Main Rd, Gokula 1st Stage, Nanjappa Reddy Colony, Yeswanthpur, Bengaluru, Karnataka 560054',
  },
]

export const account_options: OptionType[] = [
  { label: 'An existing account', disabled: true },
  { label: 'New account', disabled: false },
]

export const CustomSvgIcon = () => {
  return (
    <SvgIcon
      width="24"
      height="24"
      viewBox="0 0 24 24"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
      sx={{
        marginRight: '10px',
      }}
    >
      <path
        d="M11.6632 15.4674C11.5632 15.4674 11.4716 15.4507 11.3882 15.4174C11.3049 15.3841 11.2216 15.3257 11.1382 15.2424L6.18824 10.2924C6.0549 10.1591 5.9924 9.97989 6.00074 9.75489C6.00907 9.52989 6.0799 9.35072 6.21324 9.21739C6.3799 9.05072 6.55907 8.97989 6.75074 9.00489C6.9424 9.02989 7.11324 9.10906 7.26324 9.24239L11.6632 13.6424L16.0632 9.24239C16.1966 9.10906 16.3757 9.03406 16.6007 9.01739C16.8257 9.00072 17.0049 9.07572 17.1382 9.24239C17.3049 9.37572 17.3757 9.55072 17.3507 9.76739C17.3257 9.98406 17.2466 10.1674 17.1132 10.3174L12.1882 15.2424C12.1049 15.3257 12.0216 15.3841 11.9382 15.4174C11.8549 15.4507 11.7632 15.4674 11.6632 15.4674V15.4674Z"
        fill="#A5A8AC"
      />
    </SvgIcon>
  )
}

export const select_drop_down_options: SelectOptionType[] = [
  {
    value: '4656',
    user: 'Ross Gener',
  },
  {
    value: '4242',
    user: 'Ross Gener',
  },
]

export interface PaymentType {
  id: string
  iconSrc: string
  medium: string
  desc: string
  expectedTime: string
  active: boolean
  header?: string
}

export const paymentTypeValues: PaymentType[] = [
  {
    id: 'Debit Card',
    iconSrc: cardIcon,
    medium: 'Debit Card',
    desc: 'Send from your Visa or Mastercard.',
    expectedTime: 'January 28th',
    active: true,
    header: 'Fast and easy transfer',
  },
  {
    id: 'Credit Card',
    iconSrc: cardIcon,
    medium: 'Credit Card',
    desc: 'Send from your Visa or Mastercard.',
    expectedTime: 'January 28th',
    active: false,
  },
  {
    id: 'Bank Tranfer',
    iconSrc: bankIcon,
    medium: 'Transfer from your bank account',
    desc: 'Transfer the money using bank account',
    expectedTime: 'January 28th',
    active: true,
    header: 'Low cost transfer',
  },
  {
    id: 'SWIFT Transfer',
    iconSrc: globeIcon,
    medium: 'SWIFT Transfer',
    desc: 'Send GBP from your bank account outside the UK.',
    expectedTime: 'January 28th',
    active: false,
    header: 'Advanced transfer',
  },
]
export const horizontalSignUpStepperValues = [
  'Email',
  'Account type',
  'country',
  '2-factor-authentication',
  'Password',
]

export const getAccountCardValues = (
  onSendClick: () => void,
  onSetupClick: () => void,
  isSendActive: boolean,
  isSetupActive: boolean
) => [
  {
    id: 'Send',
    iconSrc: sendIcon,
    iconAlt: 'send logo',
    optionMain: 'Send Money',
    optionBody: 'Pay an international employee, invoice, or expense',
    active: isSendActive,
    onClick: onSendClick,
  },
  {
    id: 'Setup',
    iconSrc: setupIcon,
    iconAlt: 'setup logo',
    optionMain: 'Finish Account Setup',
    optionBody: 'Get balances in multiple currencies, and take buisness goals',
    active: isSetupActive,
    onClick: onSetupClick,
  },
]

export const countryOption: OptionType[] = [
  {
    label: 'Andora',
    disabled: false,
  },
  {
    label: 'United Kingdom',
    disabled: true,
  },
  {
    label: 'Austria',
    disabled: false,
  },
  {
    label: 'India',
    disabled: false,
  },
]

export const USER_DETAILS = [
  {
    id: 1,
    recipientName: 'Mario Gabriel',
    sendMoney: '100 GBP',
    receiveMoney: '114.68 EUR',
    setUpName: 'Ross Gener (YOU)',
    transferNumber: '#3227627272',
    refundUserOptions: select_drop_down_options,
  },
  {
    id: 2,
    recipientName: 'James',
    sendMoney: '100 EUR',
    receiveMoney: '214.68 GBP',
    setUpName: 'Gener (YOU)',
    transferNumber: '#3227627272',
    refundUserOptions: select_drop_down_options,
  },
]

export interface userOptionType {
  label: string
  icon: string
  active: boolean
  onClick?: () => void
}

export const getUserOptions = (onLogout: () => void) => [
  {
    label: 'Your details',
    icon: userIcon,
    active: false,
  },
  {
    label: 'Settings',
    icon: settingIcon,
    active: false,
  },
  {
    label: 'Help centre',
    icon: helpIcon,
    active: false,
  },
  {
    label: 'Logout',
    icon: logoutIcon,
    active: true,
    onClick: onLogout,
  },
]
export const emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/

interface signUpDetailsProps {
  [key: string]: string
}
interface signUpReducerProps {
  [key: string]: signUpDetailsProps
}

export interface storeProps {
  signUpReducer: signUpReducerProps
}

export const signUpStepperArray = [
  { stepperValue: 2, component: 'ACCOUNT_TYPE' },
  { stepperValue: 3, component: 'COUNTRY_REGISTRATION' },
  { stepperValue: 4, component: 'TWO_FACTOR_AUTHENTICATION' },
  { stepperValue: 4, component: 'OTP' },
  { stepperValue: 5, component: 'PASSWORD' },
]
const mockStore = configureStore([])
export const SendMoneyMockStore = mockStore({
  userDetail: {
    userDetails: {
      first_name: 'Mario',
      last_name: 'Gabriel',
      dob: '04-08-2005',
      country_of_residency: 'United Kingdom',
      home_address: 'home',
      city: 'city',
      pincode: '123456',
    },
    userAuthentication: {
      authenticated: false,
      error: false,
      id: 1,
      name: '',
    },
  },
})
export const mockStoreValues = mockStore({
  routerHistory: { presentStepperValue: 0 },
  transactionDetails: {
    purposeOfPOcketPay: PURPOSE_OF_POCKET_PAY_options[2],
  },
  TransferAmountReducer: {
    senderAmount: '100',
    receiverAmount: '113.00',
    senderCurrency: 'GBP',
    receiverCurrency: 'AUD',
  },
  RecipientDetailsReducer: {
    email: 'mario.gabriel@gmail.com',
    accountNo: '729019188810',
    firstName: 'Mario',
    lastName: 'Gabriel',
    IFSCCode: 'ABFJ12929G',
  },
  DirectorAndOwnerDetailsReducer: {
    directorDetailsArray: [
      {
        id: 1,
        firstName: 'Jack',
        lastName: 'Gabriel',
        dob: '1980-09-09',
        residence: 'United Kingdom',
      },
    ],
    ownerDetailsArray: [
      {
        id: 1,
        firstName: 'Jack',
        lastName: 'Gabriel',
        dob: '1980-09-09',
        residence: 'United Kingdom',
      },
    ],
  },
  userDetail: {
    userDetails: {
      first_name: 'Mario',
      last_name: 'Gabriel',
      dob: '04-08-2005',
      country_of_residency: 'United Kingdom',
      home_address: 'home',
      city: 'city',
      pincode: '123456',
    },
    userAuthentication: {
      authenticated: false,
      error: false,
      id: 1,
      name: 'name',
    },
  },
})
export const sendMoneyStepperArray = [
  { stepperValue: 1, component: 'TRANSFER_COMPONENT' },
  { stepperValue: 3, component: 'SENDING_MONEY_TYPE' },
  { stepperValue: 3, component: 'RECIPIENT_FORM' },
  { stepperValue: 4, component: 'PURPOSE_OF_POCKET_PAY' },
  { stepperValue: 4, component: 'DIRECTOR' },
  { stepperValue: 4, component: 'SHAREHOLDER' },
  { stepperValue: 5, component: 'REVIEW' },
  { stepperValue: 6, component: 'PAY_CARD' },
  { stepperValue: 6, component: 'PAY_WITH_BANK' },
]

export interface directorType {
  firstName: string
  lastName: string
  dob: string
  residence: string
}
export interface presentStepperType {
  presentStepperValue: number
}
export interface routerHistoryType {
  routerHistory: presentStepperType
}
export interface reduxStateType {
  state: routerHistoryType
}

type directorDetailsArray = {
  directorDetailsArray: VerificationDataType[]
  ownerDetailsArray: VerificationDataType[]
}
type transactionData = {
  senderAmount: string
  receiverAmount: string
  senderCurrency: string
  receiverCurrency: string
}
type purposeOfPOcketPayType = { purposeOfPOcketPay: OptionType }
type userDetailType = {
  first_name: string
  last_name: string
  dob: string
  country_of_residency: string
  home_address: string
  city: string
  pincode: string
}
type userDetailsReducerType = {
  userDetail: userDetailType
  userAuthentication: {
    authenticated: boolean
    error: boolean
    id: number
    name: string
  }
}

export interface ReduxStoreType {
  DirectorAndOwnerDetailsReducer: directorDetailsArray
  RecipientDetailsReducer: RecipientType
  transactionDetails: purposeOfPOcketPayType
  TransferAmountReducer: transactionData
  routerHistory: presentStepperType
  userDetail: userDetailsReducerType
  signUpReducer: signUpReducerProps
}
export const BankOptions = [
  { code: Sbi, label: 'State bank of India', disabled: true },
  { code: Hdfc, label: 'HDFC', disabled: true },
  { code: Hsbc, label: 'HSBC', disabled: true },
  { code: Axis, label: 'Axis', disabled: true },

  { code: Lloyd, label: 'Lloyds', disabled: true },

  { code: OtherBankLogo, label: 'Other bank', disabled: false },
]

export const DirectorDetails = [
  {
    id: 0,
    firstName: 'Ross',
    lastName: 'Genner',
    residence: 'United Kingdom',
    dob: '1985-07-12',
  },
]

export type FormErrors = {
  name: string
  email: string
  accountNo: string
  amount: string
}

export type TransferAmountState = {
  senderAmount: string
  receiverAmount: string
  senderCurrency: string
  receiverCurrency: string
}
export const SIGN_UP_ROUTE = '/signup'

export const getNumberWithoutSpaces = (phoneNumber: string): number => {
  const cleanedNumber = phoneNumber.replace(/\s/g, '')
  return Number(cleanedNumber)
}
export const CARD_DETAILS = [
  {
    id: 1,
    card_number: 9313,
    expiry_date: '2030/09/25',
    cvv: 499,
  },
  {
    id: 2,
    card_number: 3253,
    expiry_date: '2030/02/27',
    cvv: 312,
  },
]
