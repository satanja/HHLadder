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

# Frontend communication
The backend is connected with the frontend through a WebSocket connection. The frontend can either send a `GET` message, or a `POST` message, these messages are in JSON. The `command` entry in the message is always included to identify which type of message it is in de backend.  

## Messages
* The message for the `add` command frontend is:
    ```JSON
    {
        "command": "add",
        "weapon":  "foil",
        "fencer": {
            "id": 0,
            "name": "Hidde",
        }
    }
    ```
    A response message should look like the following message:
    ```JSON
    {
        "success": true,
        "errorMessage": null
    }
    ```
    The `success` indicates whether the fencer could have been added to the ladder. If not, the `errorMessage` should give an appropriate indication of what went wrong.
* The message for the `match` command:
    ```JSON
    {
        "command": "match",
        "weapon": "epee",
        "fencers": [
            {
                "fencer": {
                    "id": 0,
                    "name": "Bob",
                },
                "touches": 10
            },
            {
                "fencer": {
                    "id": 2,
                    "name": "Robin"
                },
                "touches": 8 
            }
        ]
    }
    ```
    A response should look like this:
    ```JSON
    {
        "success": true,
        "errorMessage": null,
        "fencers": [
            {
                "fencer": {
                    "id": 0,
                    "name": "Bob",
                },
                "newRank": 1,
            },
            {
                "fencer": {
                    "id": 2,
                    "name": "Robin"
                },
                "newRank": 2,
            }
        ]
    }
    ```
    Again, an appropriate error message should be given if `success` is false.
        
* The message for getting the ladder for a specific weapon from the backend:
    ```JSON
    {
        "command": "ladder",
        "weapon": "epee"
    }
    ```
    The response message should be the following:
    ```JSON
    {
    
        "fencers": [
            {
                "id": 1,
                "name": "Stefan",
                "MMR": 1200
            },
            {
                "id": 0,
                "name": "Bob",
                "MMR": 1000
            }
        ],
        "isHiddenMMR": false
    }
    ```