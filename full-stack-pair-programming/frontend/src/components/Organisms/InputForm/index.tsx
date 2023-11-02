import { Box, Button, Stack, Typography } from '@mui/material';
import TextFieldComp from 'components/Atoms/TextField';
import React, { useState } from 'react';
import {
  INITIAL_INPUT_VALUES,
  INPUT_FILED,
  InputValueType,
} from 'utils/constant';

export interface IInputForm {
  onSubmitHandler: (book: string, description: string) => void;
}
const InputForm = ({ onSubmitHandler }: IInputForm) => {
  const [inputValues, setInputValues] =
    useState<InputValueType>(INITIAL_INPUT_VALUES);

  const handleChange = (event) => {
    const { name, value } = event.target;
    console.log(name, value);
    setInputValues((prev) => ({ ...prev, [name]: value }));
  };
  const disableBtn = inputValues.book === '' || inputValues.description === '';

  return (
    <Box>
      <Stack gap="12px">
        <Typography>book name</Typography>
        <TextFieldComp
          label={INPUT_FILED.bookName}
          placeholder={INPUT_FILED.bookName}
          name="book"
          onChange={handleChange}
          value={inputValues.book}
        />
        <Typography>description</Typography>
        <TextFieldComp
          label={INPUT_FILED.desription}
          placeholder={INPUT_FILED.desription}
          name="description"
          onChange={handleChange}
          value={inputValues.description}
        />
        <Button
          onClick={() => {
            onSubmitHandler(inputValues.book, inputValues.description);
          }}
          variant="contained"
          disabled={disableBtn}
        >
          Save Book
        </Button>
      </Stack>
    </Box>
  );
};

export default InputForm;
