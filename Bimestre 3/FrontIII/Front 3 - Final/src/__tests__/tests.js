import { render, screen,  } from '@testing-library/react';
import React from 'react';
import Footer from '../Components/Footer';
import { toBeInTheDocument } from '@testing-library/jest-dom';



test('powered by', () => {
  render(<Footer/>);
  expect(screen.getByText('Powered by')).toBeInTheDocument();
})



