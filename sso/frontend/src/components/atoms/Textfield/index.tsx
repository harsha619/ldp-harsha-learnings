import {
  TextField as MuiTexField,
  TextFieldProps as MuiTextFieldProps,
  styled,
} from '@mui/material'
import React from 'react'
const StyledTextField = styled(MuiTexField)({
  MuiOutlinedInput: {
    styleOverrides: {
      root: {
        height: '2rem',
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
})
const TextFieldComp = (props: MuiTextFieldProps) => {
  return (
    <StyledTextField
      autoComplete="off"
      inputProps={{ maxLength: 70 }}
      {...props}
    />
  )
}

export default React.memo(TextFieldComp)
