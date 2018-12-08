import React, { Component } from "react";

import Ladder from "./Ladder";
import RegisterForm from "./RegisterForm";
import MatchForm from "./MatchForm";
import ConnectionBar from "./ConnectionBar";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ladders: [],
      status: ""
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
    setTimeout(() => {
      this.connect();
    }, 500);
  }

  onConnectionError(event) {
    this.setState({ status: "error" });
  }

  onConnectionMessage(event) {
    console.log("message received");
    const json = JSON.parse(event.data);
    if (json.ladders !== undefined) {
      this.setState({ ladders: json.ladders });
    }
  }

  onConnectionOpen(event) {
    this.setState({ status: "success" });
    this.getLadders();
  }

  getLadders() {
    const message = {
      command: "ladders"
    };
    this.submit(message);
  }

  submit(message) {
    this.connection.send(JSON.stringify(message));
  }

  render() {
    const ladders = this.state.ladders;
    return (
      <div>
        <ConnectionBar status={this.state.status} />
        {ladders.length === 0 ? null : (
          <div>
            <RegisterForm
              onSubmit={message => this.submit(message)}
              ladders={ladders}
            />
            <MatchForm
              ladders={ladders}
              onSubmit={message => this.submit(message)}
            />
          </div>
        )}
        {ladders.map((ladder, index) => (
          <Ladder data={ladder} key={index} />
        ))}
      </div>
    );
  }
}

export default App;
