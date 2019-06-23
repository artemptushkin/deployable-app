package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'GET'
		headers {
			header 'Accept' : 'application/json'
		}
		url('/service/user/realm/1')
	}
	response {
		status 200
		headers {
			header 'Content-Type' : 'application/json;charset=UTF-8'
		}
		body(
				id: anyInteger(),
				name: anyAlphaNumeric(),
				description: anyAlphaNumeric(),
				key: uuid()
		)
	}
}

