package userservice

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("When a POST request with a User is made, the created user's ID is returned")
    request {
        method 'POST'
        url '/user-service/users'
        body(
                name: "Michel",
                email: "michel.tds@gmail.com"
        )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 201
        body(
                id: 42,
                name: "Michel",
                email: "michel.tds@gmail.com"
        )
        headers {
            contentType(applicationJson())
        }
    }
}
