import { KeyboardArrowLeft, KeyboardArrowRight } from '@mui/icons-material';
import { Box, Button, MobileStepper, Paper, Typography } from '@mui/material';
import React, { useEffect, useState } from 'react';
import SwipeableViews from 'react-swipeable-views';
import { autoPlay } from 'react-swipeable-views-utils';

import { useTheme } from '@mui/material/styles';
import { getAllBooks } from '../../../service';
const AutoPlaySwipeableViews = autoPlay(SwipeableViews);

export interface CarouselDataType {
  bookName: string;
  description: string;
}
interface ICarouselDataType {
  carouselData: CarouselDataType[];
}

const Carousel = () => {
  const [activeStep, setActiveStep] = React.useState(0);
  const [books, setBooks] = useState([]);
  const maxSteps = books.length;
  const theme = useTheme();

  const handleStepChange = (step: number) => {
    setActiveStep(step);
  };
  const handleNext = () => {
    setActiveStep((prevActiveStep) => prevActiveStep + 1);
  };

  const handleBack = () => {
    setActiveStep((prevActiveStep) => prevActiveStep - 1);
  };

  useEffect(() => {
    getAllBooks().then((res) => {
      setBooks(res.data);
    });
  }, []);

  return (
    <Box sx={{ maxWidth: 400, flexGrow: 1 }}>
      <Paper
        square
        elevation={0}
        sx={{
          display: 'flex',
          alignItems: 'center',
          height: 50,
          pl: 2,
          bgcolor: 'grey',
        }}
      >
        <Typography>
          {books.length > 0 ? books[activeStep].book : ''}
        </Typography>
      </Paper>
      <AutoPlaySwipeableViews
        axis={theme.direction === 'rtl' ? 'x-reverse' : 'x'}
        index={activeStep}
        onChangeIndex={handleStepChange}
        enableMouseEvents
      >
        {books.reverse().map((step, index) => (
          <div key={step.book}>
            {Math.abs(activeStep - index) <= 2 ? (
              <Box
                sx={{
                  height: 255,
                  display: 'block',
                  maxWidth: 400,
                  overflow: 'hidden',
                  width: '100%',
                }}
              >
                <Typography>{step.description}</Typography>
              </Box>
            ) : null}
          </div>
        ))}
      </AutoPlaySwipeableViews>
      <MobileStepper
        steps={maxSteps}
        position="static"
        activeStep={activeStep}
        nextButton={
          <Button
            size="small"
            onClick={handleNext}
            disabled={activeStep === maxSteps - 1}
          >
            Next
            {theme.direction === 'rtl' ? (
              <KeyboardArrowLeft />
            ) : (
              <KeyboardArrowRight />
            )}
          </Button>
        }
        backButton={
          <Button size="small" onClick={handleBack} disabled={activeStep === 0}>
            {theme.direction === 'rtl' ? (
              <KeyboardArrowRight />
            ) : (
              <KeyboardArrowLeft />
            )}
            Back
          </Button>
        }
      />
    </Box>
  );
};

export default Carousel;
