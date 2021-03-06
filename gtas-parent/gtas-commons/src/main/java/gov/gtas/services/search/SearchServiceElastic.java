/*
 * All GTAS code is Copyright 2016, Unisys Corporation.
 * 
 * Please see LICENSE.txt for details.
 */
package gov.gtas.services.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.gtas.services.dto.AdhocQueryDto;

@Service
public class SearchServiceElastic implements SearchService {
	@Autowired
	private ElasticHelper elastic;
	
	@Override
	public AdhocQueryDto findPassengers(String query, int pageNumber, int pageSize, String column, String dir) {
		AdhocQueryDto rv = null;
		try {
			rv = elastic.searchPassengers(query, pageNumber, pageSize, column, dir);
		} catch (Exception e) {
			return new AdhocQueryDto("Search not available!");
		}

		return rv;
	}
}
