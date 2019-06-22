package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'POST'
		headers {
			header 'Content-Type' : 'application/json;charset=UTF-8'
		}
		url('/service/user/realm')
		body(
			name: "realmNameJson",
			description: "realmDescription"
		)
	}
	response {
		status 201
		headers {
			header 'Content-Type' : 'application/json;charset=UTF-8'
		}
		body(
			id: anyInteger(),
			name: fromRequest().body('$.name'),
			description: fromRequest().body('$.description'),
			key: uuid()
		)
	}
}

