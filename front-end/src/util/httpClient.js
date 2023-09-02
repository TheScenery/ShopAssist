import axios from 'axios';
import { getToken } from '@/util/token';

const httpClient = axios.create({
  baseURL: '/api',
  timeout: 1000,
  headers: {
    'Authorization': `Bearer ${getToken()}`
  }
});

export default httpClient;