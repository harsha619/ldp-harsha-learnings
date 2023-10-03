import DashboardPage from './components/organisms/dashBoard';
import { Login } from './components/organisms/Login';
import React, { useEffect, useState } from 'react';
import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom';
import { isExpired } from 'react-jwt';
import { useAuth0 } from '@auth0/auth0-react';
import useAuthToken from 'hooks/AuthToken';

const App = () => {
  const { isAuthenticated } = useAuth0();
  const token = useAuthToken();

  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route
            path="/dashboard"
            element={
              isAuthenticated || token ? <DashboardPage /> : <Navigate to="/" />
            }
          />
        </Routes>
      </BrowserRouter>
    </div>
  );
};
export default App;
