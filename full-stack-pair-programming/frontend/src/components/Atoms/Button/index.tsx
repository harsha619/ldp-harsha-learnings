import { ButtonProps } from '@mui/material';
import React from 'react';

const Button = ({ ...restProps }: ButtonProps) => {
  return <Button {...restProps} />;
};

export default Button;
