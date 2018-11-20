import React, { Component } from "react";

import Ladder from "./Ladder/";
import RegisterForm from "./RegisterForm";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ladder: null
    };
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
    if (json.fencers !== undefined) {
      this.setState({ ladder: json });
    }
  }

  onConnectionOpen(event) {
    console.log("Connected");
    this.getLadder();
  }

  getLadder(ladder) {
    const message = {
      command: "ladder",
      ladder: "epee"
    };
    this.connection.send(JSON.stringify(message));
  }

  render() {
    const ladder = this.state.ladder;
    return (
      <div>
        <RegisterForm />
        {ladder === null ? null : <Ladder response={ladder} name={"epee"} />}
      </div>
    );
  }
}

export default App;
