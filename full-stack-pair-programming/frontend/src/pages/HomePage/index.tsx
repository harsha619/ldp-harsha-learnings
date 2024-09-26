import { Box, Stack } from '@mui/material';
import Carousel from 'components/Organisms/Carousel';
import InputForm from 'components/Organisms/InputForm';
import React, { useEffect, useState } from 'react';
import { postBookData } from '../../service';

const HomePage = () => {
  const [carouselDisplay, setCarousel] = useState(false);
  const onFormClick = (book, description) => {
    console.log('form click', book, description);
    postBookData({ book, description }).catch((error) => {
      console.error(error.message);
    });
    setCarousel(true);
  };
  return (
    <Stack alignItems={'center'}>
      <Box width="300px" height="300px">
        {!carouselDisplay ? (
          <InputForm
            onSubmitHandler={(book, description) => {
              onFormClick(book, description);
            }}
          />
        ) : (
          <Carousel />
        )}
      </Box>
    </Stack>
  );
};

export default HomePage;
