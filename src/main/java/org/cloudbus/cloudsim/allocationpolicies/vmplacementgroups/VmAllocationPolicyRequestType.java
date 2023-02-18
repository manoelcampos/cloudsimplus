/*
 * CloudSim Plus: A modern, highly-extensible and easier-to-use Framework for
 * Modeling and Simulation of Cloud Computing Infrastructures and Services.
 * http://cloudsimplus.org
 *
 *     Copyright (C) 2023 IBM Research.
 *     Author: Pavlos Maniotis
 *
 *     This file is part of CloudSim Plus.
 *
 *     CloudSim Plus is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     CloudSim Plus is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with CloudSim Plus. If not, see <http://www.gnu.org/licenses/>.
 */
package org.cloudbus.cloudsim.allocationpolicies.vmplacementgroups;

import org.cloudbus.cloudsim.vms.VmGroup;
import org.cloudbus.cloudsim.vms.VmSimple;
import org.cloudbus.cloudsim.vms.vmplacementgroup.VmPlacementGroup;

/**
 * An enumerator with the request types that are supported by the 
 * VM placement group allocation policies. 
 * 
 * @since CloudSim Plus 7.3.2
 * 
 * @author Pavlos Maniotis
 */
public enum VmAllocationPolicyRequestType {
	
	/**
	 * Denotes a {@link VmSimple} request
	 */
	SINGLE_VM,

	/**
	 * Denotes a {@link VmGroup} request
	 */
	VM_GROUP,
	
	/**
	 * Denotes a {@link VmPlacementGroup} request
	 */
	VM_PLACEMENT_GROUP,
}
