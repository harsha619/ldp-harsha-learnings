import { createTheme } from '@mui/material/styles'
import React from 'react'
declare module '@mui/material/styles' {
  interface Components {
    MuiPickersLayout?: Components['MuiPopover']
    MuiDateCalendar?: Components['MuiPopover']
  }
  interface Palette {
    primaryColor: {
      500?: string
      300?: string
      100?: string
    }
    textColor: {
      highemp?: string
      lowemp?: string
      medemp?: string
    }
    greyColor: {
      stroke: string
      icon01: string
      icon02: string
    }
    structuralColor: {
      background?: string
      buttonhover?: string
      white?: string
      hovercolor?: string
    }
  }

  interface PaletteOptions {
    primaryColor?: {
      500?: string
      300?: string
      100?: string
    }
    textColor?: {
      highemp?: string
      lowemp?: string
      medemp?: string
    }
    greyColor: {
      stroke: string
      icon01: string
      icon02: string
    }
    structuralColor: {
      background?: string
      buttonhover?: string
      white?: string
      hovercolor?: string
    }
  }

  interface TypographyVariants {
    heading1: React.CSSProperties
    body1: React.CSSProperties
    body2: React.CSSProperties
    body3: React.CSSProperties
    caption1: React.CSSProperties
    linktext: React.CSSProperties
  }
  interface TypographyVariantsOptions {
    heading1: React.CSSProperties
    body1: React.CSSProperties
    body2: React.CSSProperties
    body3: React.CSSProperties
    caption1: React.CSSProperties
    linktext: React.CSSProperties
  }
}

declare module '@mui/material/Typography' {
  interface TypographyPropsVariantOverrides {
    heading1: true
    body1: true
    body2: true
    body3: true
    caption1: true
    linktext: true
  }
}

let theme = createTheme({
  breakpoints: {
    values: {
      xs: 0,
      sm: 601,
      md: 1081,
      lg: 1441,
      xl: 1920,
    },
  },
  spacing: 4,
  palette: {
    primaryColor: {
      500: '#7633FF',
      300: '#9764FF',
      100: '#E4D6FF',
    },
    structuralColor: {
      background: '#F8F9FA',
      buttonhover: '#F4EFFF',
      white: '#FFFFFF',
      hovercolor: '#F3F2F5',
    },
    textColor: {
      highemp: '#141414',
      medemp: '#77767A',
      lowemp: '#9F9DA3',
    },
    greyColor: {
      stroke: '#E4E4E5',
      icon01: '#141414',
      icon02: '#A5A8AC',
    },
  },

  typography: {
    fontFamily: 'Gerbera',
    heading1: {
      fontWeight: '400',
      fontSize: '24px',
      lineHeight: '40px',
      fontStyle: 'normal',
    },
    body1: {
      fontWeight: '400',
      fontSize: '20px',
      lineHeight: '32px',
      fontStyle: 'normal',
    },
    body2: {
      fontWeight: '400',
      fontSize: '17px',
      lineHeight: '24px',
      fontStyle: 'normal',
    },
    body3: {
      fontWeight: '400',
      fontSize: '16px',
      lineHeight: '24px',
      fontStyle: 'normal',
    },
    caption1: {
      fontWeight: '400',
      fontSize: '14px',
      lineHeight: '21px',
      fontStyle: 'normal',
    },
    linktext: {
      fontWeight: '400',
      fontSize: '14px',
      lineHeight: '13.3px',
      textDecoration: 'underline',
      fontStyle: 'normal',
    },
  },
  components: {
    MuiFormLabel: {
      styleOverrides: {
        root: {
          color: '#9F9DA3',
        },
      },
    },
    MuiOutlinedInput: {
      styleOverrides: {
        root: {
          '& .MuiOutlinedInput-notchedOutline': {
            border: `1px solid #E4E4E5`,
          },
          '&:hover .MuiOutlinedInput-notchedOutline': {
            border: `1px solid #E4E4E5`,
          },
          '&.Mui-focused .MuiOutlinedInput-notchedOutline': {
            border: '0px solid',
            borderBottom: '1px solid #7633FF',
          },
        },
      },
    },
    MuiInputLabel: {
      styleOverrides: {
        root: {
          '&.Mui-focused  ': {
            color: '#7633FF',
          },
        },
      },
    },

    MuiPickersLayout: {
      styleOverrides: {
        root: {
          width: '306px',
        },
      },
    },
    MuiDateCalendar: {
      styleOverrides: {
        root: {
          width: '306px',
          height: '315px',
        },
      },
    },
  },
})

theme = createTheme({ ...theme })

export default theme

export const bannerBoxShadow =
  '0px 0px 1px 0px rgba(20, 20, 20, 0.12), 0px 0px 8px 0px rgba(20, 20, 20, 0.04), 0px 8px 8px 0px rgba(20, 20, 20, 0.04)'

export const primaryButtonShadow = '0px 8px 24px 0px rgba(85, 51, 255, 0.24)'
