import { TextField, TextFieldProps } from '@mui/material';
import React from 'react';

const TextFieldComp = ({ ...props }: TextFieldProps) => {
  return <TextField {...props} />;
};

export default TextFieldComp;
