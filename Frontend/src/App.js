import React, { Component } from 'react';

import Ladder from './Ladder/';

const response = require('./Ladder/response.json');

class App extends Component {

  constructor(props) {
    super(props);
    this.connection = null;
    this.connect();
  }

  connect() {
    const l = window.location;
    this.connection = new WebSocket(
      `${l.protocol === "https:" ? "wss" : "ws"}://${l.hostname}:4242`
    );
    this.connection.onclose = event => this.onConnectionClose(event);
    this.connection.onerror = event => this.onConnectionError(event);
    this.connection.onmessage = event => this.onConnectionMessage(event);
    this.connection.onopen = event => this.onConnectionOpen(event);
  }

  onConnectionClose(event) {
    console.log("Closed");
  }

  onConnectionError(event) {
    console.log("Error");
  }

  onConnectionMessage(event) {
    console.log("message received");
    const json = JSON.parse(event.data);
    console.log(json);
  }

  onConnectionOpen(event) {
    console.log("Connected");
  }

  render() {
    return (
      <div>
        <Ladder response={response}/>
      </div>
    );
  }
}

export default App;
