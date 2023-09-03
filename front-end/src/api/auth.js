import httpClient from '@/util/httpClient';

export const login = async (loginData) => {
  const response = await httpClient.post('/auth/login', { email: loginData.userName, password: loginData.password });
  return response.data;
};

export const getCurrentUserInfo = async () => {
  const response = await httpClient.get('/currentUser');
  return response.data;
};