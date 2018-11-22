import React, { Component } from "react";
import Window from "../Window";
import {
  FormGroup,
  ControlLabel,
  DropdownButton,
  MenuItem,
  Button
} from "react-bootstrap";

class MatchForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedLadder: "Select a ladder",
      winner: "Select the winner",
      loser: "Select the loser"
    };
  }

  setLadder(eventKey) {
    this.setState({ selectedLadder: eventKey });
  }

  setWinner(eventKey) {
    this.setState({ winner: eventKey });
  }

  setLoser(eventKey) {
    this.setState({ loser: eventKey });
  }

  onSubmit() {
    const message = {
      command: "match",
      ladder: this.state.selectedLadder,
      fencers: {
        winner: this.state.winner,
        loser: this.state.loser
      }
    };
    this.props.onSubmit(message);
  }

  render() {
    const ladders = this.props.ladders;
    return (
      <Window>
        <form>
          <FormGroup controlId="formLadder">
            <ControlLabel>Ladder</ControlLabel>
            <br />
            <DropdownButton
              bsStyle="default"
              title={this.state.selectedLadder}
              id={1}
            >
              {ladders.map((ladder, index) => {
                return (
                  <CustomMenuItem
                    eventKey={ladder.name}
                    key={index}
                    onSelect={eventKey => this.setLadder(eventKey)}
                    selected={this.state.selectedLadder}
                  >
                    {ladder.name}
                  </CustomMenuItem>
                );
              })}
            </DropdownButton>
          </FormGroup>
          <FormGroup controlId="formWinner">
            <ControlLabel>Winner</ControlLabel>
            <br />
            <DropdownButton bsStyle="success" title={this.state.winner} id={2}>
              {ladders
                .filter(ladder => {
                  return ladder.name === this.state.selectedLadder;
                })
                .map(ladder => {
                  return ladder.fencers.map((fencer, index) => {
                    return (
                      <CustomMenuItem
                        eventKey={fencer.name}
                        key={index}
                        onSelect={eventKey => this.setWinner(eventKey)}
                        selected={this.state.winner}
                      >
                        {fencer.name}
                      </CustomMenuItem>
                    );
                  });
                })}
            </DropdownButton>
          </FormGroup>
          <FormGroup controlId="formLoser">
            <ControlLabel>Loser</ControlLabel>
            <br />
            <DropdownButton bsStyle="danger" title={this.state.loser} id={3}>
              {ladders
                .filter(ladder => {
                  return ladder.name === this.state.selectedLadder;
                })
                .map(ladder => {
                  return ladder.fencers.map((fencer, index) => {
                    return (
                      <CustomMenuItem
                        eventKey={fencer.name}
                        key={index}
                        onSelect={eventKey => this.setLoser(eventKey)}
                        selected={this.state.loser}
                      >
                        {fencer.name}
                      </CustomMenuItem>
                    );
                  });
                })}
            </DropdownButton>
          </FormGroup>
          <Button type="submit" onClick={() => this.onSubmit()}>
            Submit
          </Button>
        </form>
      </Window>
    );
  }
}

const CustomMenuItem = props => {
  const { selected, eventKey, key, onSelect } = props;
  if (eventKey === selected) {
    return (
      <MenuItem
        eventKey={eventKey}
        key={key}
        onSelect={eventKey => onSelect(eventKey)}
        active
      >
        {props.children}
      </MenuItem>
    );
  }
  return (
    <MenuItem
      eventKey={eventKey}
      key={key}
      onSelect={eventKey => onSelect(eventKey)}
    >
      {props.children}
    </MenuItem>
  );
};

export default MatchForm;
