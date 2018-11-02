# Supported commands
* `add <weapon> <name>` Adds a fencer to the ladder with the specified ladder
* `match <weapon> <name1> <name2> <score1> <score2>` Processes a match between two fencers and their scores, `score1` for `fencer1`, and `score2` for `fencer2`.
* `print <flag> <optional>` Prints a ladder
    * `<flag>`
        * `-a` to print all ladders for each weapon
        * `-w` to print the ladder for a specific weapon
            * `<optional>` required for the weapon

* `weapon` can be the following strings:
    * `epee`
    * `foil`
    * `sabre`