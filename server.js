const express = require('express');
const cors = require("cors");
const app = express();
const port = 8000;

app.use( express.json() ); //tells my app that it can parse json
app.use( express.urlencoded({ extended: true }) ); //tells my app that it can gather form information
app.use(cors({
    origin: "*",
    methods: ["GET","POST","PUT","DELETE"]
})); //tells the app that it is allowed to share resources with a react application








app.listen(port, () => console.log(`Listening on port: ${port}`))