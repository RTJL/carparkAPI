# Carpark SG REST API

<!-- TOC depthFrom:1 depthTo:2 withLinks:1 updateOnSave:1 orderedList:0 -->
- [Get All Carparks](#Get-All-Carparks)
- [Get Carpark](#Get-Carpark)
- [Documentation history](#documentation-history)

<!-- /TOC -->

**Get All Carparks**
----
Returns information of all carparks

* **URL**

  /carparks

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**

   None

   **Optional:**
 
   None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:**  <br />
    ```javascript
    {
      id: 1,
      location: {
        lat: 1.287953,
        lng: 103.851784,
        address: "Blk 731 Yishun Street 71"
      },
      freeLots: 100
    }, {
      ...
    }, {
      id: "SE12",
      location: {
        address: "BLK 211-222 SERANGOON AVENUE 4",
        lat: 1.357843857,
        lng: 103.8730891
      },
      freeLots: 405
    }
    ```
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "No carparks available" }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/carparks/1",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```

**Get Carpark**
----
  Returns information of a carpark

* **URL**

  /carparks/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**

   `id=[string]`

   **Optional:**
 
   None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:**  <br />
    ```javascript
        {
            id: 1,
            location: {
                lat: 1.287953,
                lng: 103.851784,
                address: "Blk 731 Yishun Street 71"
            },
            freeLots: 100
        }
    ```
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "ID not found" }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/carparks/1",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```

## Documentation history

- V1: 2019-08-21, first draft.