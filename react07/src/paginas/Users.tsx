import { useState } from "react";
import type { User } from "../Models/User";
import { useLocation, useNavigate } from "react-router-dom";

function Users () {


        const [user,setUser] = useState<User[]>([]);

        const location = useLocation();
        const navigate = useNavigate();

  return (
    <div>
      <h1>Users</h1>
      <p>Esta es la página de usuarios.</p>
    </div>
  );
}

export default Users;