import axios from 'axios';
import { getToken } from '@/util/token';
import router from '@/router';

const httpClient = axios.create({
  baseURL: '/api',
  timeout: 1000,
  headers: {
    'Authorization': `Bearer ${getToken()}`
  }
});

httpClient.interceptors.response.use((response) => {
  return response;
}, (error) => {
  console.log(error);
  if (error.response.status === 401) {
    router.push('/auth/login');
  }
  return error;
});

export default httpClient;