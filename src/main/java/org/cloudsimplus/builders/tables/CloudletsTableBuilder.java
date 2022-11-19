/*
 * CloudSim Plus: A modern, highly-extensible and easier-to-use Framework for
 * Modeling and Simulation of Cloud Computing Infrastructures and Services.
 * http://cloudsimplus.org
 *
 *     Copyright (C) 2015-2021 Universidade da Beira Interior (UBI, Portugal) and
 *     the Instituto Federal de Educação Ciência e Tecnologia do Tocantins (IFTO, Brazil).
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
package org.cloudsimplus.builders.tables;

import org.cloudbus.cloudsim.cloudlets.Cloudlet;
import org.cloudbus.cloudsim.core.Identifiable;

import java.util.ArrayList;
import java.util.List;

/**
 * Builds a table for printing simulation results from a list of Cloudlets.
 * It defines a set of default columns but new ones can be added
 * dynamically using the {@code addColumn()} methods.
 *
 * <p>The basic usage of the class is by calling its constructor,
 * giving a list of Cloudlets to be printed, and then
 * calling the {@link #build()} method.</p>
 *
 * @author Manoel Campos da Silva Filho
 * @since CloudSim Plus 1.0
 */
public class CloudletsTableBuilder extends TableBuilderAbstract<Cloudlet> {
    private static final String SECONDS = "Seconds";
    private static final String CPU_CORES = "CPU cores";
    private static final String ID = "ID";
	
	private static final String DEFAULT_TIME_FORMAT = "%.1f";
	private static final String DEFAULT_LENGTH_FORMAT = "%d";
	private static final String DEFAULT_ID_FORMAT = "%d";
	private static final String DEFAULT_PE_FORMAT = "%d";

    /**
     * Instantiates a builder to print the list of Cloudlets using the a
     * default {@link MarkdownTable}.
     * To use a different {@link Table}, check the alternative constructors.
     *
     * @param list the list of Cloudlets to print
     */
    public CloudletsTableBuilder(final List<? extends Cloudlet> list) {
        super(list);
    }

    /**
     * Instantiates a builder to print the list of Cloudlets using the
     * given {@link Table}.
     *
     * @param list the list of Cloudlets to print
     * @param table the {@link Table} used to build the table with the Cloudlets data
     */
    public CloudletsTableBuilder(final List<? extends Cloudlet> list, final Table table) {
        super(list, table);
    }

    @Override
    protected void createTableColumns() {
        
        // Cloudlet
        addColDataFunction(getTable().addColumn("Cloudlet", ID), Identifiable::getId);
        
        // Status
        // 1 extra space to ensure proper formatting
        addColDataFunction(getTable().addColumn(" Status") , cloudlet -> cloudlet.getStatus().name());
        
        // DC (Datacenter)
        addColDataFunction(getTable().addColumn("DC", ID,DEFAULT_ID_FORMAT), cloudlet -> cloudlet.getVm().getHost().getDatacenter().getId());
        
        // Host
        addColDataFunction(getTable().addColumn("Host", ID,DEFAULT_ID_FORMAT), cloudlet -> cloudlet.getVm().getHost().getId());
        
        // Host PEs
        addColDataFunction(getTable().addColumn("Host PEs ", CPU_CORES,DEFAULT_PE_FORMAT), cloudlet -> cloudlet.getVm().getHost().getWorkingPesNumber());
        
        // VM
        addColDataFunction(getTable().addColumn("VM", ID,DEFAULT_ID_FORMAT), cloudlet -> cloudlet.getVm().getId());
        
        // VM PEs
        // 3 extra spaces to ensure proper formatting
        addColDataFunction(getTable().addColumn("   VM PEs", CPU_CORES,DEFAULT_PE_FORMAT), cloudlet -> cloudlet.getVm().getNumberOfPes());
        
        // CloudletLen
        addColDataFunction(getTable().addColumn("CloudletLen", "MI",DEFAULT_LENGTH_FORMAT), Cloudlet::getLength);
        
        // FinishedLen
        addColDataFunction(getTable().addColumn("FinishedLen", "MI",DEFAULT_LENGTH_FORMAT), Cloudlet::getFinishedLengthSoFar);
        
        // CloudletPEs
        addColDataFunction(getTable().addColumn("CloudletPEs", CPU_CORES,DEFAULT_PE_FORMAT), Cloudlet::getNumberOfPes);

        // StartTime
        addColDataFunction(getTable().addColumn("StartTime", SECONDS,DEFAULT_TIME_FORMAT), Cloudlet::getExecStartTime);

        // FinishTime
        addColDataFunction(getTable().addColumn("FinishTime", SECONDS,DEFAULT_TIME_FORMAT), cl -> cl.getFinishTime());

        // ExecTime
        addColDataFunction(getTable().addColumn("ExecTime", SECONDS,DEFAULT_TIME_FORMAT), cl ->  cl.getActualCpuTime());
    }

}
