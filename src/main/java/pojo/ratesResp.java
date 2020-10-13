package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ratesResp {

	public List<RateList> rates;

	public List<RateList> getRates() {
		return rates;
	}

	public void setRates(List<RateList> rates) {
		this.rates = rates;
	}
}
