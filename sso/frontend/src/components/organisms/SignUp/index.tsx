import { Box, Typography, Stack, Button } from '@mui/material';
import Textfield from 'components/atoms/Textfield';
import React, { useState } from 'react';

const SignUp = () => {
  const [inputValues, setInputValues] = useState({
    email: '',
    password: '',
    confirmPassword: '',
  });
  const onChange = (event) => {
    const { name, value } = event.target;
    setInputValues((prev) => ({ ...prev, [name]: value }));
  };
  return (
    <div>
      <Box width={'500px'}>
        <Typography>LOgin Form</Typography>
        <Stack>
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
          <Textfield
            name="ConfirmPassword"
            type="password"
            onChange={onChange}
            value={inputValues.confirmPassword}
          />
          <Button variant="contained"> SignUp</Button>
        </Stack>
      </Box>
    </div>
  );
};

export default SignUp;
