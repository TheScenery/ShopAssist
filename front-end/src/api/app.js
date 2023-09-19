import HttpClient from '@/util/httpClient';

export const getMyApps = async () => {
  const response = await HttpClient.get('/app/my-apps');
  return response.data;
};