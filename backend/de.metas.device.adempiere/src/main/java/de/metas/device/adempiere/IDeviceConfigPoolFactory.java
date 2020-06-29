package de.metas.device.adempiere;

import org.adempiere.service.ClientId;
import org.adempiere.util.net.IHostIdentifier;

import de.metas.organization.OrgId;
import de.metas.util.ISingletonService;

/*
 * #%L
 * de.metas.device.adempiere
 * %%
 * Copyright (C) 2017 metas GmbH
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

public interface IDeviceConfigPoolFactory extends ISingletonService
{
	IDeviceConfigPool createDeviceConfigPool(IHostIdentifier clientHost, ClientId adClientId, OrgId adOrgId);
}
