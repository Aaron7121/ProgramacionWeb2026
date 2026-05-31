import {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import axios from "axios";
import type {Comment} from "../models/Comment.tsx";
import {
    Box,
    Button,
    Card,
    CardContent,
    Chip,
    Container,
    Paper,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow,
    Typography
} from "@mui/material";


function Comments() {

    const {id} = useParams<{ id: string }>();

    const [comments, setComments] = useState<Comment[]>([]);

    const url = `https://jsonplaceholder.typicode.com/posts/${id}/comments`;

    useEffect(() => {
        axios.get<Comment[]>(url)
            .then(res => {
                setComments(res.data);
            })
            .catch(err => alert(err));
    }, [id]);

    return (
        <Box
            sx={{
                minHeight: "100vh",
                background: "linear-gradient(to right, #ece9e6, #ffffff)",
                py: 6
            }}
        >
            <Container maxWidth="lg">

                {/* HEADER */}
                <Card
                    elevation={6}
                    sx={{
                        borderRadius: 5,
                        mb: 4,
                        overflow: "hidden"
                    }}
                >

                    <Box
                        sx={{
                            background: "linear-gradient(135deg, #7b1fa2, #9c27b0)",
                            color: "white",
                            p: 4
                        }}
                    >
                        <Typography
                            variant="h4"
                            sx={{
                                fontWeight: "bold",
                                mb: 1
                            }}
                        >
                            Comentarios
                        </Typography>

                        <Typography variant="body1">
                            Lista de comentarios del post seleccionado
                        </Typography>
                    </Box>

                    <CardContent
                        sx={{
                            display: "flex",
                            justifyContent: "space-between",
                            alignItems: "center",
                            flexWrap: "wrap",
                            gap: 2
                        }}
                    >

                        <Chip
                            label={`Post ID: ${id}`}
                            color="primary"
                            sx={{
                                fontSize: "1rem",
                                px: 1,
                                py: 2.5,
                                fontWeight: "bold"
                            }}
                        />

                        <Button
                            variant="contained"
                            component={Link}
                            to={`/posts/${id}`}
                            sx={{
                                borderRadius: 3,
                                px: 4,
                                py: 1.2,
                                fontWeight: "bold"
                            }}
                        >
                            Regresar
                        </Button>

                    </CardContent>

                </Card>

                {/* TABLA */}
                <TableContainer
                    component={Paper}
                    elevation={8}
                    sx={{
                        borderRadius: 5,
                        overflow: "hidden"
                    }}
                >

                    <Table>

                        <TableHead>

                            <TableRow
                                sx={{
                                    backgroundColor: "#1976d2"
                                }}
                            >
                                <TableCell
                                    sx={{
                                        color: "white",
                                        fontWeight: "bold",
                                        fontSize: "1rem"
                                    }}
                                >
                                    ID
                                </TableCell>

                                <TableCell
                                    sx={{
                                        color: "white",
                                        fontWeight: "bold",
                                        fontSize: "1rem"
                                    }}
                                >
                                    Nombre
                                </TableCell>

                                <TableCell
                                    sx={{
                                        color: "white",
                                        fontWeight: "bold",
                                        fontSize: "1rem"
                                    }}
                                >
                                    Email
                                </TableCell>

                                <TableCell
                                    sx={{
                                        color: "white",
                                        fontWeight: "bold",
                                        fontSize: "1rem"
                                    }}
                                >
                                    Comentario
                                </TableCell>



                            </TableRow>

                        </TableHead>

                        <TableBody>

                            {comments.map((comment) => (

                                <TableRow
                                    key={comment.id}
                                    hover
                                    sx={{
                                        transition: "0.2s",
                                        "&:hover": {
                                            backgroundColor: "#f5f5f5"
                                        }
                                    }}
                                >

                                    <TableCell>
                                        <Typography sx={{ontWeight: "bold"}}>
                                            {comment.id}
                                        </Typography>
                                    </TableCell>

                                    <TableCell>
                                        {comment.name}
                                    </TableCell>

                                    <TableCell>
                                        <Typography
                                            color="primary"
                                            sx={{
                                                fontWeight: "500"
                                            }}
                                        >
                                            {comment.email}
                                        </Typography>
                                    </TableCell>

                                    <TableCell
                                        sx={{
                                            maxWidth: 400
                                        }}
                                    >
                                        {comment.body}
                                    </TableCell>

                                </TableRow>

                            ))}

                        </TableBody>

                    </Table>

                </TableContainer>

            </Container>
        </Box>
    );
}

export default Comments;