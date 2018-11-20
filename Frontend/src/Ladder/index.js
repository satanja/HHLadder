import React from "react";
import { Table } from "react-bootstrap";
import styled from "styled-components";

/**
 * Simple table with all the fencers of a specific ladder
 * Author: S.A. Tanja
 * Props:
 *  - data All the data of the ladder
 *    - fencers: array of fencer objects
 *    - isHiddenMMR: whether to draw the MMR in the table
 *  - name The name of the ladder
 */
const Ladder = props => {
  const { name, fencers, isHiddenMMR } = props.data;
  return (
    <TableWindow>
      <Table striped bordered condensed hover>
        <Caption>{name}</Caption>
        <thead>
          <tr>
            <th>Position</th>
            <th>Name</th>
            {isHiddenMMR ? null : <th>MMR</th>}
          </tr>
        </thead>
        <tbody>
          {fencers.map((fencer, index) => {
            const position = `${index + 1}.`;
            const { name, MMR } = fencer;
            return (
              <tr key={position}>
                <td>{position}</td>
                <td>{name}</td>
                {isHiddenMMR ? null : <td>{MMR}</td>}
              </tr>
            );
          })}
        </tbody>
      </Table>
    </TableWindow>
  );
};

const TableWindow = styled.div`
  width: 90%;
  margin: 0 auto;
`;

const Caption = styled.caption`
  text-align: center;
  font-weight: bold;
  color: #000000;
`;

export default Ladder;
