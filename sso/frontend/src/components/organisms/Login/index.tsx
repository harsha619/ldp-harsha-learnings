import { Box, Stack, Typography } from '@mui/material';
import Button from 'components/atoms/Button';
import Textfield from 'components/atoms/Textfield';
import React, { useState } from 'react';

export const Login = () => {
  const [inputValues, setInputValues] = useState({
    email: '',
    password: '',
  });
  const onChange = (event) => {
    const { name, value } = event.target;
    setInputValues((prev) => ({ ...prev, [name]: value }));
  };
  return (
    <div>
      <Box width={'500px'}>
        <Typography>Login Form</Typography>
        <Stack gap={'20px'}>
          <Textfield
            name="email"
            onChange={onChange}
            value={inputValues.email}
          />
          <Textfield
            name="password"
            type="password"
            onChange={onChange}
            value={inputValues.password}
          />
          <Button variant="contained"> Login</Button>
        </Stack>
      </Box>
    </div>
  );
};
