package de.metas.rest_api.bpartner.impl;

import static de.metas.rest_api.bpartner.SwaggerDocConstants.BPARTER_IDENTIFIER_DOC;
import static de.metas.rest_api.bpartner.SwaggerDocConstants.CONTACT_IDENTIFIER_DOC;
import static de.metas.rest_api.bpartner.SwaggerDocConstants.LOCATION_IDENTIFIER_DOC;
import static de.metas.rest_api.bpartner.SwaggerDocConstants.NEXT_DOC;
import static de.metas.rest_api.bpartner.SwaggerDocConstants.SINCE_DOC;

import java.util.UUID;

import javax.annotation.Nullable;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.metas.Profiles;
import de.metas.rest_api.JsonPagingDescriptor;
import de.metas.rest_api.JsonPagingDescriptor.JsonPagingDescriptorBuilder;
import de.metas.rest_api.bpartner.BPartnerRestEndpoint;
import de.metas.rest_api.bpartner.JsonBPartnerComposite;
import de.metas.rest_api.bpartner.JsonBPartnerCompositeList;
import de.metas.rest_api.bpartner.JsonBPartnerCompositeList.JsonBPartnerCompositeListBuilder;
import de.metas.rest_api.bpartner.JsonBPartnerLocation;
import de.metas.rest_api.bpartner.JsonBPartnerUpsertRequest;
import de.metas.rest_api.bpartner.JsonBPartnerUpsertRequestItem;
import de.metas.rest_api.bpartner.JsonContact;
import de.metas.rest_api.bpartner.JsonUpsertResponse;
import de.metas.rest_api.bpartner.JsonUpsertResponse.JsonUpsertResponseBuilder;
import de.metas.rest_api.bpartner.JsonUpsertResponseItem;
import de.metas.util.Check;
import de.metas.util.time.SystemTime;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;

/*
 * #%L
 * de.metas.business.rest-api-impl
 * %%
 * Copyright (C) 2019 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

@RestController
@Profile(Profiles.PROFILE_App)
// the spelling "Bpartner" is to avoid swagger spelling it "b-partner-rest.."
public class BpartnerRestController implements BPartnerRestEndpoint
{

	//
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved bpartner"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("{bpartnerIdentifier}")
	@Override
	public ResponseEntity<JsonBPartnerComposite> retrieveBPartner(

			@ApiParam(value = BPARTER_IDENTIFIER_DOC) //
			@PathVariable("bpartnerIdentifier") //
			@NonNull final String bpartnerIdentifier)
	{
		final JsonBPartnerComposite result = MockDataUtil.createMockBPartnerComposite(bpartnerIdentifier);
		return ResponseEntity.ok(result);
	}

	//
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved location"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("{bpartnerIdentifier}/location/{locationIdentifier}")
	@Override
	public ResponseEntity<JsonBPartnerLocation> retrieveBPartnerLocation(

			@ApiParam(value = BPARTER_IDENTIFIER_DOC) //
			@PathVariable("bpartnerIdentifier") //
			@NonNull final String bpartnerIdentifier,

			@ApiParam(value = LOCATION_IDENTIFIER_DOC) //
			@PathVariable("locationIdentifier") //
			@NonNull final String locationIdentifier)
	{
		final JsonBPartnerLocation location = MockDataUtil.createMockLocation("l1", "CH");
		return ResponseEntity.ok(location);
	}

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved contact"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("{bpartnerIdentifier}/contact/{contactIdentifier}")
	@Override
	public ResponseEntity<JsonContact> retrieveBPartnerContact(

			@ApiParam(value = BPARTER_IDENTIFIER_DOC) //
			@PathVariable("bpartnerIdentifier") //
			@NonNull final String bpartnerIdentifier,

			@ApiParam(value = CONTACT_IDENTIFIER_DOC) //
			@PathVariable("contactIdentifier") //
			@NonNull final String contactIdentifier)
	{
		final JsonContact contact = MockDataUtil.createMockContact("c1");
		return ResponseEntity.ok(contact);
	}

	public static final String MOCKED_NEXT = UUID.randomUUID().toString();

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved bpartner(s)"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "There is no page for the given 'next' value")
	})
	@GetMapping
	@Override
	public ResponseEntity<JsonBPartnerCompositeList> retrieveBPartnersSince(

			@ApiParam(SINCE_DOC) //
			@RequestParam(name = "since", required = false) //
			@Nullable final Long epochTimestampMillis,

			@ApiParam(NEXT_DOC) //
			@RequestParam(name = "next", required = false) //
			@Nullable final String next)
	{
		final JsonPagingDescriptorBuilder pagingDescriptor = JsonPagingDescriptor.builder()
				.pageSize(1)
				.totalSize(2)
				.resultTimestamp(SystemTime.millis());

		final JsonBPartnerCompositeListBuilder compositeList = JsonBPartnerCompositeList.builder();

		if (Check.isEmpty(next))
		{
			pagingDescriptor.nextPage(MOCKED_NEXT); // will return the first page with the 2nd page's identifier
			compositeList.item(MockDataUtil.createMockBPartnerComposite("1234"));
		}
		else
		{
			if (MOCKED_NEXT.equals(next))
			{
				pagingDescriptor.nextPage(null); // will return the 2nd and last page
				compositeList.item(MockDataUtil.createMockBPartnerComposite("1235"));
			}
			else
			{
				return new ResponseEntity<JsonBPartnerCompositeList>(
						(JsonBPartnerCompositeList)null,
						HttpStatus.NOT_FOUND);
			}
		}

		compositeList.pagingDescriptor(pagingDescriptor.build());
		return ResponseEntity.ok(compositeList.build());
	}

	//
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully created or updated bpartner(s)"),
			@ApiResponse(code = 401, message = "You are not authorized to create or update the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
	})
	@PostMapping
	@Override
	public ResponseEntity<JsonUpsertResponse> createOrUpdateBPartner(
			// the requestBody annotation needs to be present it here; otherwise, at least swagger doesn't get it
			@RequestBody @NonNull final JsonBPartnerUpsertRequest bpartners)
	{
		final JsonUpsertResponseBuilder response = JsonUpsertResponse.builder();

		for (final JsonBPartnerUpsertRequestItem requestItem : bpartners.getRequestItems())
		{
			final JsonUpsertResponseItem responseItem = JsonUpsertResponseItem.builder()
					.externalId(requestItem.getExternalId())
					.metasfreshId(MockDataUtil.nextMetasFreshId())
					.build();
			response.responseItem(responseItem);
		}
		return new ResponseEntity<>(response.build(), HttpStatus.CREATED);
	}

	//
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully created or updated location"),
			@ApiResponse(code = 401, message = "You are not authorized to create or update the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
	})
	@PostMapping("{bpartnerIdentifier}/location")
	@Override
	public ResponseEntity<JsonUpsertResponseItem> createOrUpdateLocation(

			@ApiParam(value = BPARTER_IDENTIFIER_DOC) //
			@PathVariable("bpartnerIdentifier") //
			@NonNull final String bpartnerIdentifier,

			@RequestBody @NonNull final JsonBPartnerLocation location)
	{
		final JsonUpsertResponseItem resonseItem = JsonUpsertResponseItem.builder()
				.externalId(location.getExternalId())
				.metasfreshId(MockDataUtil.nextMetasFreshId())
				.build();
		return new ResponseEntity<>(resonseItem, HttpStatus.CREATED);
	}

	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully created or updated contact"),
			@ApiResponse(code = 401, message = "You are not authorized to create or update the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
	})
	@PostMapping("{bpartnerIdentifier}/contact")
	@Override
	public ResponseEntity<JsonUpsertResponseItem> createOrUpdateContact(

			@ApiParam(value = BPARTER_IDENTIFIER_DOC, allowEmptyValue = false) //
			@PathVariable("bpartnerIdentifier") //
			@NonNull final String bpartnerIdentifier,

			@RequestBody @NonNull final JsonContact contact)
	{
		final JsonUpsertResponseItem resonseItem = JsonUpsertResponseItem.builder()
				.externalId(contact.getExternalId())
				.metasfreshId(MockDataUtil.nextMetasFreshId())
				.build();
		return new ResponseEntity<>(resonseItem, HttpStatus.CREATED);
	}

}