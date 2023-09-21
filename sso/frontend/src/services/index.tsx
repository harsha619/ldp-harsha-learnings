import API from './API';

export const registerUser = async (data: any) => {
  return await API.post('users/register', data);
};

export const authenticateUser = async (data: any) => {
  return await API.post('users/login', data);
};
