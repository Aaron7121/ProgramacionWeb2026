import { useParams, Link } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

import {
    Box,
    CardContent,
    TextField,
    Typography,
    Button,
    Card,
    CardActions,
    Divider,
    FormControlLabel,
    Checkbox
} from "@mui/material";

import type { ToDo } from "../models/ToDo";

function ToDoDetalle() {

    const url = "https://jsonplaceholder.typicode.com/todos";

    const { id } = useParams<{ id: string }>();

    const [todo, setTodo] = useState<ToDo | null>(null);

    useEffect(() => {

        axios
            .get<ToDo>(`${url}/${id}`)
            .then(response => setTodo(response.data))
            .catch(error => alert("Error: " + error));

    }, [id]);

    const handleGuardar = () => {

        if (!todo) return;

        axios
            .put<ToDo>(`${url}/${id}`, todo)
            .then(response => {
                setTodo(response.data);
                alert("ToDo actualizado");
            })
            .catch(error => alert("Error: " + error));
    };

    if (!todo) {
        return <div>Cargando...</div>;
    }

    return (

        <Box
            sx={{
                maxWidth: 700,
                margin: "20px auto",
                px: 2
            }}
        >

            <Card
                variant="outlined"
                sx={{ borderRadius: 3 }}
            >

                <CardContent
                    sx={{
                        display: "flex",
                        flexDirection: "column",
                        gap: 2
                    }}
                >

                    <Box
                        sx={{
                            display: "flex",
                            justifyContent: "space-between",
                            alignItems: "center"
                        }}
                    >

                        <Typography
                            variant="h5"
                            sx={{ fontWeight: "bold" }}
                        >
                            Editar ToDo
                        </Typography>

                        <Typography
                            variant="caption"
                            color="text.secondary"
                        >
                            ID: {todo.id}
                        </Typography>

                    </Box>

                    <Divider />

                    {/* USER ID */}

                    <TextField
                        label="User ID"
                        type="number"
                        value={todo.userId}
                        fullWidth
                        onChange={(e) =>
                            setTodo({
                                ...todo,
                                userId: Number(e.target.value)
                            })
                        }
                    />

                    {/* TITLE */}

                    <TextField
                        label="Título"
                        value={todo.title}
                        fullWidth
                        multiline
                        rows={3}
                        onChange={(e) =>
                            setTodo({
                                ...todo,
                                title: e.target.value
                            })
                        }
                    />

                    {/* COMPLETED */}

                    <FormControlLabel
                        control={
                            <Checkbox
                                checked={todo.completed}
                                onChange={(e) =>
                                    setTodo({
                                        ...todo,
                                        completed: e.target.checked
                                    })
                                }
                            />
                        }
                        label="Completado"
                    />

                </CardContent>

                <CardActions
                    sx={{
                        justifyContent: "flex-end",
                        px: 4,
                        pb: 4,
                        gap: 2
                    }}
                >

                    <Button
                        variant="contained"
                        onClick={handleGuardar}
                    >
                        Guardar
                    </Button>

                    <Button
                        variant="outlined"
                        component={Link}
                        to="/users"
                    >
                        Regresar
                    </Button>

                </CardActions>

            </Card>

        </Box>
    );
}

export default ToDoDetalle;