import { InputValueType } from 'utils/constant';
import API from './API';

export const postBookData = (bookData: InputValueType) => {
  return API.post('/book', bookData);
};

export const getAllBooks = () => {
  return API.get('/book');
};
