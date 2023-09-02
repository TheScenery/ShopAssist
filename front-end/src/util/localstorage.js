const storeKey = 'shop-assist';

const processKey = (key) => `${storeKey}--${key}`;

export const saveLocalstorage = (key, val) => {
  window.localStorage.setItem(processKey(key), JSON.stringify(val));
};
export const getLocalstorage = (key) => {
  const rawValue = window.localStorage.getItem(processKey(key));
  if (rawValue) {
    return JSON.parse(rawValue);
  }
};