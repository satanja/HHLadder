import React from "react";
import { ErrorWindow, WarningWindow } from "../Components";

const ConnectionBar = props => {
  const status = props.status;
  if (status === "disconnected") {
    return (
      <WarningWindow>
        <p>Connecting...</p>
      </WarningWindow>
    );
  } else if (status === "error") {
    return (
      <ErrorWindow>
        <p>Could not establish a connection.</p>
      </ErrorWindow>
    );
  } else {
    return null;
  }
};

export default ConnectionBar;
