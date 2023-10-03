import DashboardPage from './components/organisms/dashBoard';
import { Login } from './components/organisms/Login';
import React, { useEffect, useState } from 'react';
import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom';
import { isExpired } from 'react-jwt';
import { useAuth0 } from '@auth0/auth0-react';

const App = () => {
  const { isAuthenticated } = useAuth0();
  const [token, setToken] = useState<string>('');
  useEffect(() => {
    const token: string = localStorage.getItem('token')!;
    setToken(token);
  }, [token, isAuthenticated]);
  function isExpired(token: any) {
    throw new Error('Function not implemented.');
  }

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
