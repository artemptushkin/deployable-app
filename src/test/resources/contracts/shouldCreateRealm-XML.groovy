package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'POST'
		headers {
			header 'Content-Type' : 'application/xml; charset=utf-8'
		}
		url('/service/user/realm')
		body(
			equalToXml(
				"""<realm name='realmNameXml'>
  <description>realmDescription</description>
</realm>"""
			)
		)
	}
	response {
		status 201
		headers {
			header 'Content-Type' : 'application/xml; charset=utf-8'
		}
	}
}

