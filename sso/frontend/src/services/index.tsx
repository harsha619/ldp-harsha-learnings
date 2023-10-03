import API from './API';

export const registerUser = async (data: any) => {
  return await API.post('/users/register', data);
};

export const authenticateUser = async (data: any) => {
  return await API.post('/users/login', data);
};
API.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);
