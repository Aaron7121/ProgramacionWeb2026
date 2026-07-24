import {useEffect, useState} from "react";
import type {Cliente} from "../model/Cliente.ts";

import {Box, Card, Container, Table, TableBody, TableCell, TableHead, TableRow, Typography} from "@mui/material";
import axios from "axios"
import {TableBar} from "@mui/icons-material";



function Clientes (){

    const [cliente, setCliente] = useState<Cliente[]>([])


        useEffect(
            () => {

                axios.get<Cliente[]>('http://localhost:9090/api/clientes').
                then(response => setCliente(response.data)

                ).catch((error )=> alert(error))

            },[]

        );


    return(

        <>
            <Typography>
                <Container>



                <Box>
                    <Card>

                       <Table>
                           <TableHead>
                            <TableCell> Id</TableCell>
                               <TableCell> Nombre</TableCell>
                               <TableCell> Apellido</TableCell>
                               <TableCell> Direccion</TableCell>


                           </TableHead>
                           <TableBody>
                               {
                                   cliente.map(
                                       cli=>
                                           <TableRow key={cli.id}>
                                               <TableCell> {cli.id}</TableCell>
                                               <TableCell> {cli.nombre}</TableCell>
                                               <TableCell> {cli.apellido}</TableCell>
                                               <TableCell> {cli.direccion}</TableCell>


                                           </TableRow>






                                   )




                               }




                           </TableBody>

                       </Table>

                    </Card>

                </Box>
                </Container>
            </Typography>


        </>
    )
}
export default Clientes