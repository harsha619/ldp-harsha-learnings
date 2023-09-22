import { useAuth0 } from '@auth0/auth0-react';
import { Box, Stack, Typography } from '@mui/material';
import Button from 'components/atoms/Button';
import Textfield from 'components/atoms/Textfield';
import React, { useEffect, useState } from 'react';
import { isExpired } from 'react-jwt';
import { useNavigate } from 'react-router-dom';
import { authenticateUser, registerUser } from 'services';

export const Login = () => {
  const [inputValues, setInputValues] = useState({
    email: '',
    password: '',
  });
  const onChange = (event) => {
    const { name, value } = event.target;
    setInputValues((prev) => ({ ...prev, [name]: value }));
  };
  const token = localStorage.getItem('token');
  const isMyTokenExpired = isExpired(token!);
  const { loginWithRedirect, isAuthenticated } = useAuth0();
  const navigate = useNavigate();
  useEffect(() => {
    if (!isMyTokenExpired) navigate('/dashboard');
  }, []);

  useEffect(() => {
    if (isAuthenticated) navigate('/dashboard');
  }, [isAuthenticated, navigate]);

  return (
    <div>
      <Box width={'500px'}>
        <Typography>Login Form</Typography>
        <Stack gap={'20px'}>
          <Textfield
            name="email"
            onChange={onChange}
            value={inputValues.email}
            placeholder="email"
          />
          <Textfield
            name="password"
            type="password"
            onChange={onChange}
            value={inputValues.password}
            placeholder="password"
          />
          <Button
            variant="contained"
            onClick={() => {
              console.log(inputValues, 'd');

              authenticateUser({ ...inputValues }).then((res) => {
                console.log(res.data.token, 'a');

                localStorage.setItem('token', res.token);
              });
            }}
          >
            {' '}
            Login
          </Button>
          <Button
            onClick={() => {
              loginWithRedirect({
                authorizationParams: {
                  connection: 'google-oauth2',
                  redirect_uri: window.location.origin + '/dashboard',
                },
                appState: {
                  returnTo: '/dashboard',
                },
              });
            }}
            variant="contained"
          >
            Google login
          </Button>
        </Stack>
      </Box>
    </div>
  );
};
