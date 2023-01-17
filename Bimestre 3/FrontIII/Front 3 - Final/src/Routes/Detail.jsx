import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
      backgroundColor: theme.palette.common.black,
      color: theme.palette.common.white,
  },
  [`&.${tableCellClasses.body}`]: {
      fontSize: 14,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.action.hover,
  },
  '&:last-child td, &:last-child th': {
      border: 0,
  },
}));

const Detail = () => {
  // Consumiendo el parametro dinamico de la URL deberan hacer un fetch a un user en especifico
  const { id } = useParams();
  const [data, setData] = useState([]);

  useEffect(() => {
    console.log("Making user API call ...");
    axios.get(`https://jsonplaceholder.typicode.com/users/${id}`)
      .then(res => { setData(res.data);})
      .catch(err => console.log(err))
  } ,[id]);


  return (
    <>
      <h1 style={{marginTop: 'auto'}}>{`Detail Dentist ID : ${id}`}</h1>
      <React.Fragment>
            <TableContainer component={Paper} sx={{ marginTop: '20px' }}>
              <Table  sx={{ minWidth: 700 }} aria-label="customized table">
                <TableHead>
                  <TableRow > 
                    <StyledTableCell align="center">Name</StyledTableCell>
                    <StyledTableCell align="center">Email</StyledTableCell>
                    <StyledTableCell align="center">Phone</StyledTableCell>
                    <StyledTableCell align="center">Website</StyledTableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                    <StyledTableRow align="center">
                      <StyledTableCell align="center">{data.name}</StyledTableCell>
                      <StyledTableCell align="center">{data.email}</StyledTableCell>
                      <StyledTableCell align="center">{data.phone}</StyledTableCell>
                      <StyledTableCell align="center">{data.website}</StyledTableCell>
                    </StyledTableRow>
                </TableBody>
              </Table>
            </TableContainer>
      </React.Fragment >
    </>
  )
}

export default Detail