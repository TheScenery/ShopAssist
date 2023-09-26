import HttpClient from '@/util/httpClient';

export const getMyApps = async () => {
  const response = await HttpClient.get('/app/my-apps');
  return response.data;
};

export const createApp = async (data) => {
  const response = await HttpClient.post('/app/create', data);
  return response.data;
};