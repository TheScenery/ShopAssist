import { getLocalstorage, saveLocalstorage } from '@/util/localstorage';

const tokenKey = 'access-token';
export const saveToken = (token) => {
  saveLocalstorage(tokenKey, token);
};

export const getToken = () => {
  return getLocalstorage(tokenKey);
};