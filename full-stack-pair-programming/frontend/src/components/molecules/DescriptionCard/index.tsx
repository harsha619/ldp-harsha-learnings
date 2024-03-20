import { Box, Stack, Typography } from '@mui/material';
import React from 'react';

export interface IDescription {
  bookName: string;
  description: string;
}
const DescriptionCard = ({ bookName, description }: IDescription) => {
  return (
    <Box>
      <Stack margin={'24px'} justifyContent={'center'}>
        <Typography> {bookName}</Typography>
      </Stack>
      <Box margin={'12px'}>
        <Typography>{description}</Typography>
      </Box>
    </Box>
  );
};

export default DescriptionCard;
